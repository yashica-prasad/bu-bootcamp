class Contact{
    private String name;
    private String phone;

    Contact(String strname, String strphone){
        name = strname;
        phone = strphone;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", getName(), getPhone());
    }

    public static void main(String[] args){
    
    }
}