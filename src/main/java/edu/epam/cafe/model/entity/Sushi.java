package edu.epam.cafe.model.entity;

public class Sushi {
    private long sushiId;
    private String image;
    private String name;
    private String description;
    private double price;

    public Sushi(String image, String name, String description, double price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Sushi() {

    }

    public long getSushiId() {
        return sushiId;
    }

    public void setSushiId(long sushiId) {
        this.sushiId = sushiId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sushi sushi = (Sushi) o;

        if (sushiId != sushi.sushiId) return false;
        if (Double.compare(sushi.price, price) != 0) return false;
        if (image != null ? !image.equals(sushi.image) : sushi.image != null) return false;
        if (name != null ? !name.equals(sushi.name) : sushi.name != null) return false;
        return description != null ? description.equals(sushi.description) : sushi.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (sushiId ^ (sushiId >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sushi{");
        sb.append("sushiId=").append(sushiId);
        sb.append(", image='").append(image).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
