package ip.springbootmongodb;

import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("john", 8, false),
                        new Review("teddy", 9, true)
                )
        );
        Hotel ibis = new Hotel(
                "ibis",
                90,
                new Address("Bucharest ", "Romania"),
                Arrays.asList(
                        new Review("Terry", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "softel",
                200,
                new Address("Rome ", "Italy"),
                new ArrayList<>()

        );

        //drop all hotels
        //this.hotelRepository.deleteAll();

        //add out hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot,ibis,sofitel);
        this.hotelRepository.save(hotels);

    }
}
