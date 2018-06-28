package com.example.nastisch.cakeroom.Model;

public class Sharing {

    private int sharID;
    private int pID;
    private int socNetworkID;
    private int emailTypeID;
    private String shareViaSocNetworkName;
    private String shareViaEmailName;

    public Sharing(int sharID, int socNetworkID, int emailTypeID, String shareViaSocNetworkName, String shareViaEmailName) {
        this.sharID = sharID;
        this.socNetworkID = socNetworkID;
        this.emailTypeID = emailTypeID;
        this.shareViaSocNetworkName = shareViaSocNetworkName;
        this.shareViaEmailName = shareViaEmailName;
    }

    public int getSocNetworkID() {
        return socNetworkID;
    }

    public void setSocNetworkID(int socNetworkID) {
        this.socNetworkID = socNetworkID;
    }

    public int getEmailTypeID() {
        return emailTypeID;
    }

    public void setEmailTypeID(int emailTypeID) {
        this.emailTypeID = emailTypeID;
    }

    public String getShareViaSocNetworkName() {
        return shareViaSocNetworkName;
    }

    public void setShareViaSocNetworkName(String shareViaSocNetworkName) {
        this.shareViaSocNetworkName = shareViaSocNetworkName;
    }

    public String getShareViaEmailName() {
        return shareViaEmailName;
    }

    public void setShareViaEmailName(String shareViaEmailName) {
        this.shareViaEmailName = shareViaEmailName;
    }

    public int getSharID() {
        return sharID;
    }

    public int getpID() {
        return pID;
    }
}
