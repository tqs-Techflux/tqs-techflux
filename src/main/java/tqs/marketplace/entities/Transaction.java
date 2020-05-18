package tqs.marketplace.entities;

public class Transaction {
    private int transactionID;
    private int buyerID;
    private int sellerID;
    private int productID;

    public Transaction(int transactionID, int buyerID, int sellerID, int productID){
        this.transactionID = transactionID;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.productID = productID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", buyerID=" + buyerID +
                ", sellerID=" + sellerID +
                ", productID=" + productID +
                '}';
    }
}
