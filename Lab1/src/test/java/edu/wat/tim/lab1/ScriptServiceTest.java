package edu.wat.tim.lab1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wat.tim.lab1.service.ScriptService;

@SpringBootTest
class ScriptServiceTest {
    @Autowired
    ScriptService scriptService;

    @Test
    public void testCalc() {
        String script = """
                   var x = 1;
                   var y = 2;
                   x + y;
                """;

        assert scriptService.exec(script).equals("3");
    }

    @Test
    public void testAddAndRemoveParent() {
        String addScript = """
                var ChildEntity = Java.type('pl.edu.wat.tim.lab1.model.ChildEntity');
                var ParentEntity = Java.type('pl.edu.wat.tim.lab1.model.ParentEntity');
                var Set = Java.type('java.util.Set');

                var nowyParent = new ParentEntity("nowyParent");
                ParentEntityRepository.save(nowyParent).getId();
                                """;
        String id = scriptService.exec(addScript);
        String deleteScript = "ParentEntityRepository.deleteById(\"" + id + "\")";
        assert scriptService.exec(deleteScript) != null;
    }


}