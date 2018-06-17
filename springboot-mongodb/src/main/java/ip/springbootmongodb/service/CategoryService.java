package ip.springbootmongodb.service;

import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Service Layer should be used for Transactional processes
 *
 * Calls Repository Layers
 *
 */
@Service
public interface CategoryService {

    public List<String> findAll();

}
