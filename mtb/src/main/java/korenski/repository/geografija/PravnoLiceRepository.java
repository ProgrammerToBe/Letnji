package korenski.repository.geografija;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import korenski.model.geografija.Klijent;
import korenski.model.geografija.NaseljenoMesto;
import korenski.model.geografija.PravnoLice;

@Repository
public interface PravnoLiceRepository extends CrudRepository<PravnoLice, Long>{
	public PravnoLice save(PravnoLice pravnoLice);
	public PravnoLice findOne(Long id);
	public void delete(Long id);
	public Set<PravnoLice> findAll();
	public PravnoLice findByJmbg(String jmbg);
	public PravnoLice findByIme(String ime);
	public PravnoLice findByPrezime(String prezime);
	public PravnoLice findByAdresa(String adresa);
	public PravnoLice findByTelefon(String telefon);
	public PravnoLice findByEmail(String email);
	public PravnoLice findByPib(String pib);
	public PravnoLice findByFax(String fax);
	public PravnoLice findByOdobrio(String odobrio);
	public Set<PravnoLice> findByNaseljenoMesto(NaseljenoMesto naseljenoMesto);
	
	public Set<PravnoLice> findByJmbgContainingIgnoreCaseOrImeContainingIgnoreCaseOrPrezimeContainingIgnoreCaseOrAdresaContainingIgnoreCaseOrTelefonContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPibContainingIgnoreCaseOrFaxContainingIgnoreCaseOrOdobrioContainingIgnoreCase(String jmbg,
			String ime, String prezime, String adresa, String telefon, String email, String pib, String fax, String odobrio);
	public Set<PravnoLice> findByJmbgContainingIgnoreCaseOrImeContainingIgnoreCaseOrPrezimeContainingIgnoreCaseOrAdresaContainingIgnoreCaseOrTelefonContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPibContainingIgnoreCaseOrFaxContainingIgnoreCaseOrOdobrioContainingIgnoreCaseAndNaseljenoMesto(String jmbg,
			String ime, String prezime, String adresa, String telefon, String email, String pib, String fax, String odobrio, NaseljenoMesto naseljenoMesto);
}
