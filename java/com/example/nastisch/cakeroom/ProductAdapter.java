package com.example.nastisch.cakeroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nastisch.cakeroom.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter implements Filterable {

    private List<Product> mProductList;
    private List<Product> mProductListOrig;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;
    private boolean mShowQuantity;

    public ProductAdapter(List<Product> list, LayoutInflater inflater, boolean showQuantity, boolean showCheckbox) {
        mProductList = list;
        mInflater = inflater;
        mShowQuantity = showQuantity;
        mShowCheckbox = showCheckbox;
    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final List<Product> results = new ArrayList<Product>();
                if (mProductListOrig == null)
                    mProductListOrig = mProductList;
                if (constraint != null) {
                    if (mProductListOrig != null && mProductListOrig.size() > 0) {
                        for (final Product p : mProductListOrig) {
                            if (p.getpName().toLowerCase().contains(constraint.toString()))
                                results.add(p);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mProductList = (List<Product>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView.findViewById(R.id.imgVwItem);

            item.productTitle = (TextView) convertView.findViewById(R.id.txtVwProductName);

            item.productPrice = (TextView) convertView.findViewById(R.id.txtVwPrice);

            item.productRating = (TextView) convertView.findViewById(R.id.txtVwPRating);

            item.productQuantity = (TextView) convertView.findViewById(R.id.txtVwQuantity);

            item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product curProduct = mProductList.get(position);

        item.productImageView.setImageDrawable(curProduct.pImage);
        item.productTitle.setText(curProduct.pName);
        item.productPrice.setText("Price per each: "+ String.valueOf(curProduct.pPricePerEach) + " NZD");
        item.productRating.setText("Rating: "+ curProduct.pReviews);


        // Show the check box in the cart or not
        if(!mShowCheckbox) {
            item.productCheckbox.setVisibility(View.GONE); }
        else {
            if(curProduct.pSelected == true)
                item.productCheckbox.setChecked(true);
            else
                item.productCheckbox.setChecked(false); }


        // Show the quantity in the cart or not
        if (mShowQuantity) {
            item.productQuantity.setText("Quantity: " + ShoppingCartHelper.getProductQuantity(curProduct));
           // item.productChooseQuantity.setText(ShoppingCartHelper.getProductQuantity(curProduct));
        } else {
            // Hide the view
            item.productQuantity.setVisibility(View.GONE); }

        return convertView; }


    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        TextView productPrice;
        TextView productRating;
        EditText productChooseQuantity;
        TextView productQuantity;
        CheckBox productCheckbox;
    }

}