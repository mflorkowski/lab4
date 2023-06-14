package pl.edu.wat.tim.lab1.service;


import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.wat.tim.lab1.repository.ChildEntityRepository;
import edu.wat.tim.lab1.repository.ParentEntityRepository;

@Service
@Slf4j
public class ScriptService {
    private final ChildEntityRepository childEntityRepository;
    private final ParentEntityRepository parentEntityRepository;

    @Autowired
    public ScriptService(ChildEntityRepository childEntityRepository, ParentEntityRepository parentEntityRepository) {
        this.childEntityRepository = childEntityRepository;
        this.parentEntityRepository = parentEntityRepository;
    }

    public String exec(String script) {
        try (Context context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build()) {
            var bindings = context.getBindings("js");
            bindings.putMember("childEntityRepository",childEntityRepository);
            bindings.putMember("parentEntityRepository", parentEntityRepository);
            return context.eval("js", script).toString();
        } catch (PolyglotException e) {
            log.error("Error executing", e);
            return e.getMessage() + "\n" + e.getSourceLocation().toString();
        }
    }
}