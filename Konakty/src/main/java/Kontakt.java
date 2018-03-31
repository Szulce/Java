public class Kontakt {

    private String imie;
    private String nazwisko;
    private String telefon;
    private String adres;
    private String email;

    public void Kontakt(String imie)
    {
        this.imie=imie;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void showK()
    {
        System.out.println(this.getImie()+" "+this.getNazwisko());
        System.out.println(this.getAdres()+" tel.:"+this.getTelefon()+" "+this.getEmail());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
