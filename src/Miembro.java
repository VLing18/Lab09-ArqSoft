public class Miembro {
    private int id;
    private int age;
    private String gender;
    private String membershipType;

    // Constructor
    public Miembro(int id, int age, String gender, String membershipType) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.membershipType = membershipType;
    }

    // Método para convertir a JSON manualmente (ya que no usamos librerías)
    public String toJson() {
        return String.format("{\"member_id\": %d, \"age\": %d, \"gender\": \"%s\", \"membership_type\": \"%s\"}",
                id, age, gender, membershipType);
    }
}