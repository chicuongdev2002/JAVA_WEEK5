package vn.edu.fit.iuh.repositories;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;import vn.edu.fit.iuh.enities.Company;@Repositorypublic interface CompanyRepository extends JpaRepository<Company, Long> {}