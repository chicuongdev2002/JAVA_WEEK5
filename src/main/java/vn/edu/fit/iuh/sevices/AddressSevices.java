package vn.edu.fit.iuh.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.fit.iuh.enities.company;
import vn.edu.fit.iuh.repositories.companyRepository;

import java.util.List;
import java.util.Optional;

public class companySevices {
    private final companyRepository companyRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public companySevices(companyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public boolean save(company company) {
        try {
            companyRepository.save(company);

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }

    public Optional<company> findById(long id) {
        return companyRepository.findById(id);
    }

    public List<company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Boolean> update(company company) {
        if (!companyRepository.existsById(company.getId())) { // Sử dụng phương thức existsById để kiểm tra sự tồn tại
            return Optional.empty(); // Trả về empty nếu không tồn tại
        }

        try {
            companyRepository.save(company);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Optional.of(false);
    }

    public Optional<Boolean> delete(long id) {
        if (!companyRepository.existsById(id)) {
            return Optional.empty();
        }
        try {
            companyRepository.deleteById(id);
            return Optional.of(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.of(false);
    }

}
