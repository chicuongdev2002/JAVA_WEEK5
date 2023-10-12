package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "dob",columnDefinition = "date")
    private LocalDate dob;
    @Column(name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "full_name",columnDefinition = "varchar(255)")
    private String fullName;
    @Column(name = "phone",columnDefinition = "varchar(15)")
    private String phone;
   @OneToOne
   @JoinColumn(referencedColumnName = "add_id",name = "address")
    private Address adress;
   @OneToMany(mappedBy = "candidate")
   private List<CandidateSkill> candidateSkills;
   @OneToMany(mappedBy = "candidate")
   private List<Experience> experiences;

//    public Candidate(UUID id) {
//        this.id = id;
//    }
//
//    public UUID getIdAdress() {
//        return adress.getId();
//    }
//    public void setAdress(UUID adressId) {
//        this.adress = new Address(adressId);
//    }

//    @Override
//    public String toString() {
//        return "Candidate{" +
//                "id=" + id +
//                ", dob=" + dob +
//                ", email='" + email + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", phone='" + phone + '\'' +
//                ", adress=" +adress.getId()+
//                '}';
//    }
}
