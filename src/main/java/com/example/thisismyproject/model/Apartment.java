package com.example.thisismyproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "metro")
    private String metro;
    @Column(name = "minutes")
    private int minutes;
    @Column(name = "style")
    private String styles;
    @Column(name = "comment")
    private String comment;
    @Column(name = "price")
    private long price;
    @Column(name = "nature")
    private double percentOfNature;
    @Column(name = "rooms")
    private int rooms;
    @Column(name = "meters")
    private int meters;
    @Column(name = "type_Building")
    private String typeOfBuilding;
    @Column(name = "side")
    private String side;
    @Column(name = "comments")
    private String comments;
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getPercentOfNature() {
        return percentOfNature;
    }

    public void setPercentOfNature(double percentOfNature) {
        this.percentOfNature = percentOfNature;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public void setTypeOfBuilding(String typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
    public Apartment() {
    }

    public Apartment(String metro, int minutes, String styles, String comment, long price, double percentOfNature, int rooms, int meters, String typeOfBuilding, String comments, String side) {
        this.metro = metro;
        this.minutes = minutes;
        this.styles = styles;
        this.comment = comment;
        this.price = price;
        this.percentOfNature = percentOfNature;
        this.rooms = rooms;
        this.meters = meters;
        this.typeOfBuilding = typeOfBuilding;
        this.comments = comments;
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return id == apartment.id && minutes == apartment.minutes && price == apartment.price && Double.compare(apartment.percentOfNature, percentOfNature) == 0 && Objects.equals(metro, apartment.metro) && styles == apartment.styles && Objects.equals(comment, apartment.comment) && rooms == apartment.rooms && meters == apartment.meters && typeOfBuilding == apartment.typeOfBuilding && Objects.equals(comments, apartment.comments) && side == apartment.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metro, minutes, styles, comment, price, percentOfNature, rooms, meters, typeOfBuilding, comments, side);
    }
}
/** нужно как то сделать так, чтобы была возможность заполнять только данные определенного вида
 * впоследствии они долыжны каститься от стринг ак типу-значению в конструкторе enum, по скольку значения типа Enum в таблице PostrgreSQLk быть не может*/

//какого то черта