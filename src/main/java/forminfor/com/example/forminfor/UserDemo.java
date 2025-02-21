package forminfor.com.example.forminfor;

import jakarta.persistence.*;

@Table()
@Entity
public class UserDemo {
    @Id
    @Column
    //1.  GenerationType.AUTO là kiểu generate primary key mặc định cho phép persistence provider
    // tự lựa chọn kiểu mà nó muốn.
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // 2.GenerationType.IDENTITY là kiểu dễ sử dụng nhất nhưng về mặt hiệu năng thì nó không phải là một lựa chọn hàng đầu.
    // GenerationType.IDENTITY dựa trên một dữ liệu tăng dần (AUTO_INCREMENT) trong database,
    // cho phép database sinh một giá trị mới với mỗi thao tác insert.
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //3. Đây là kiểu generate được Hibernate khuyến khích sử dụng, GenerationType.SEQUENCE
    // Hibernate sẽ tạo ra một bảng HIBERNATE_SEQUENCE trong database dùng để lưu trữ giá trị tiếp theo của primary key.
    // Nó sẽ thực thi một câu lệnh SQL SELECT để lấy giá trị tiếp theo trong bảng HIBERNATE_SEQUENCE
    // khi thực thi một câu lệnh SQL INSERT. Bởi vì giá trị tiếp theo có thể lấy được từ bảng HIBERNATE_SEQUENCE
    // nên các câu lệnh SQL Insert không cần thiết phải thực hiện ngay lập tức, điều này cho phép Hibernate
    // sử dụng tính năng JDBC Batch để tối ưu hóa hiệu xuất.
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int age;


    public UserDemo() {
    }

    public UserDemo(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}