public class AddressBuilder {
  private Address address;

  public AddressBuilder() {
    this.address = new Address();
  }

  public AddressBuilder withName(String name) {
    this.address.setName(name);
    return this;
  }

  public AddressBuilder withPhoneNumber(String phoneNumber) {
    this.address.setPhoneNumber(phoneNumber);
    return this;
  }

  public AddressBuilder withAddress2(String address2) {
    this.address.setAddress1(address2);
    return this;
  }

  public AddressBuilder withAddress1(String address1) {
    this.address.setAddress1(address1);
    return this;
  }

  public AddressBuilder withCity(String city) {
    this.address.setCity(city);
    return this;
  }

  public AddressBuilder withState(String state) {
    this.address.setState(state);
    return this;
  }

  public AddressBuilder withEmail(String email) {
    this.address.setEmail(email);
    return this;
  }

  public Address build() {
    return this.address;
  }
}
