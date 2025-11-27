package resources_chief;

public class Materiaux
{
    private String name;
    private int quantity;
    private String unit;
    private String supplier;
    private String lastOrder;
    private String status;

    public Materiaux(String name, int quantity, String unit, String supplier, String lastOrder, String status)
    {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.supplier = supplier;
        this.lastOrder = lastOrder;
        this.status = status;
    }

    public void display()
    {
        System.out.println(name + " - " + quantity + " " + unit + " - " + supplier + " - Last Order: " + lastOrder + " - Status: " + status);
    }
}
