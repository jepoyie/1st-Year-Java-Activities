public class PassByReference {
    public String name;
    public int age;
    public PassByReference(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {
        PassByReference person = new PassByReference("Janpol", 18);
        System.out.println("Age before: " + person.getAge());

        changeAge(person, 20);
        System.out.println("Age after: " + person.getAge());
    }

    public static void changeAge(PassByReference person, int newAge) {
        person.setAge(newAge);
    }
}