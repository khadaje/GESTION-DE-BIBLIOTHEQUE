package dao.lui.projet2024;

import java.util.List;

public interface Dao<K> {
	K get(long id);

	List<K> getAll();

	void save(K k);

	void delete(K k);

	void update(K k, String[] args);




}
