package net.danielgill.tfl;

import java.util.List;

import org.junit.jupiter.api.Test;

import net.danielgill.tfl.route.Line;

public class LineTest {
    
    @Test
    public void lineTest() throws APIException {
        List<Line> lines = TfLAPI.Line.getRoutes();
        for(Line r: lines) {
            System.out.println(r.mode);
        }
    }
}
