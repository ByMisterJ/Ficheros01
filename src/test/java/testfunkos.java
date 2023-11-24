import org.example.MapeoJson.csv.funkos;
import org.example.MapeoJson.csv.Mainfunkos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class testfunkos {

    @Test
    public void testmeterArray(){
        ArrayList<funkos> funk = new ArrayList<>();
        LocalDate FECHA_LANZAMIENTO = LocalDate.parse("2023-10-05");
        LocalDate FECHA_LANZAMIENTOO = LocalDate.parse("2022-11-05");
        funkos f1 = new funkos("fd6c6f58-7c6b-434b-82ab-01d2d6e4434b","Peaky Blinders Tommy","OTROS",52.99,FECHA_LANZAMIENTO);
        funkos f2 = new funkos("f31r","Paco","OTROS",52.99,FECHA_LANZAMIENTO);
        funkos f3 = new funkos("tj65","Luis","OTROS",51.99,FECHA_LANZAMIENTOO);
        funk.add(f1);
        funk.add(f2);
        funk.add(f3);
        int fechaf = (int) funk.stream().filter(p-> (p.getFecha_lanzamiento().getYear()==2023)).count();
        Assertions.assertEquals(fechaf,2);
    }


}
