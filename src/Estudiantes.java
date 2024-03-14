public class Estudiantes {
    private String name;
    private String phone;
    private String email;
    private String postalZip;
    private String country;

    public Estudiantes(String name, String phone, String email, String postalZip, String country) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalZip = postalZip;
        this.country = country;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Método para imprimir los detalles del estudiante
    @Override
    public String toString() {
        return "Nombre: " + name + "\nTeléfono: " + phone + "\nEmail: " + email + "\nCódigo Postal: " + postalZip + "\nPaís: " + country;
    }
}
