package model;


public class Nutri {

    private String id;

    /**
     * Nom du produit
     */
    private String nomProduit;

    /**
     * Grade de nutrition
     */
    private String nutritionGrade;
    private String packaging;
    private String paysVente;
    private String paysOrigine;
    private String categorie;
    private String ingredientDescription;
    private String quantity;


    public Nutri(String id, String product_name_fr, String nutritionGrade, String packaging, String paysOrigine, String paysVente, String categorie, String ingredientDescription, String quantity) {
        this.id = id;
        this.nomProduit = product_name_fr;
        this.nutritionGrade = nutritionGrade;
        this.packaging = packaging;
        this.paysOrigine = paysOrigine;
        this.paysVente = paysVente;
        this.categorie = categorie;
        this.ingredientDescription = ingredientDescription;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public String getPaysVente() {
        return paysVente;
    }

    public void setPaysVente(String paysVente) {
        this.paysVente = paysVente;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
}
