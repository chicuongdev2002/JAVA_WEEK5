package vn.edu.fit.iuh.sevices;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import vn.edu.fit.iuh.enities.company;import vn.edu.fit.iuh.enities.Candidate;import vn.edu.fit.iuh.repositories.companyRepository;import vn.edu.fit.iuh.repositories.CandidateRepository;import java.util.List;import java.util.Optional;public class CandidateService {    private final CandidateRepository candidateRepository;    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());    public CandidateService(CandidateRepository candidateRepository) {        this.candidateRepository = candidateRepository;    }    public boolean save(Candidate candidate) {        try {            candidateRepository.save(candidate);            return true;        } catch (Exception e) {            logger.error(e.getMessage());        }        return false;    }    public Optional<Candidate> findById(long id) {        return candidateRepository.findById(id);    }    public List<Candidate> findAll() {        return candidateRepository.findAll();    }    public Optional<Boolean> update(Candidate candidate) {        if (!candidateRepository.existsById(candidate.getId())) { // Sử dụng phương thức existsById để kiểm tra sự tồn tại            return Optional.empty(); // Trả về empty nếu không tồn tại        }        try {            candidateRepository.save(candidate);            return Optional.of(true);        } catch (Exception e) {            logger.error(e.getMessage());        }        return Optional.of(false);    }    public Optional<Boolean> delete(long id) {        if (!candidateRepository.existsById(id)) {            return Optional.empty();        }        try {            candidateRepository.deleteById(id);            return Optional.of(true);        } catch (Exception e) {            logger.error(e.getMessage());        }        return Optional.of(false);    }}