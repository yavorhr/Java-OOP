public class Address {
  private String name;
  private String email;
  private String phoneNumber;
  private String country;
  private String state;
  private String city;
  private String address1;
  private String address2;

  public Address() {
  }


  public Address setName(String name) {
    this.setName(name);
    return this;
  }

  public Address setEmail(String email) {
    this.email = email;
    return this;
  }

  public Address setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Address setCountry(String country) {
    this.country = country;
    return this;
  }

  public Address setState(String state) {
    this.state = state;
    return this;
  }

  public Address setCity(String city) {
    this.city = city;
    return this;
  }

  public Address setAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public Address setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }
}
