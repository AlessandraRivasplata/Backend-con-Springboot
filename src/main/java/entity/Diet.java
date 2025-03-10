package entity;

import jakarta.persistence.*;

@Entity
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "texture", length = 255, nullable = false)
    private String texture;

    @Column(name = "dietType", length = 255, nullable = false)
    private String dietType;

    @Column(name = "isAutonomous", nullable = false)
    private boolean isAutonomous;

    @Column(name = "prothesisHolder", length = 255)
    private String prothesisHolder;

    @Column(name = "consistency", length = 255)
    private String consistency;

    @Column(name = "restrictions", length = 500)
    private String restrictions;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public boolean isAutonomous() {
        return isAutonomous;
    }

    public void setAutonomous(boolean autonomous) {
        isAutonomous = autonomous;
    }

    public String getProthesisHolder() {
        return prothesisHolder;
    }

    public void setProthesisHolder(String prothesisHolder) {
        this.prothesisHolder = prothesisHolder;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
}
