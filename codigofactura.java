class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem(new InvoiceItem("Item 1", 100));
        invoice.addItem(new InvoiceItem("Item 2", 200));
        invoice.addItem(new InvoiceItem("Item 3", 300));

        DiscountedInvoice discountedInvoice = new DiscountedInvoice(0.1);
        discountedInvoice.addItem(new InvoiceItem("Discounted Item 1", 500));
        discountedInvoice.addItem(new InvoiceItem("Discounted Item 2", 600));

        TaxedInvoice taxedInvoice = new TaxedInvoice(0.05);
        taxedInvoice.addItem(new InvoiceItem("Taxed Item 1", 700));
        taxedInvoice.addItem(new InvoiceItem("Taxed Item 2", 800));

        invoice.print();
        System.out.println();
        discountedInvoice.print();
        System.out.println();
        taxedInvoice.print();
    }
}
interface Printable {





    void print();
}

class InvoiceItem {
    private String description;
    private double price;

    public InvoiceItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Invoice implements Printable {
    private List<InvoiceItem> items;

    public Invoice() {
        items = new ArrayList<>();
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public void removeItem(InvoiceItem item) {
        items.remove(item);
    }

    public double getTotal() {
        double total = 0;
        for (InvoiceItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void print() {
        System.out.println("Invoice:");
        for (InvoiceItem item : items) {
            System.out.println(item.getDescription() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + getTotal());
    }
}

class DiscountedInvoice extends Invoice {
    private double discount;

    public DiscountedInvoice(double discount) {
        this.discount = discount;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Discount: $" + discount);
        System.out.println("Total after discount: $" + (getTotal() * (1 - discount)));
    }
}

class TaxedInvoice extends Invoice {
    private double tax;

    public TaxedInvoice(double tax) {
        this.tax = tax;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Tax: $" + tax);
        System.out.println("Total after tax: $" + (getTotal() * (1 + tax)));
    }
}


