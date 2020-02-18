package be.technifutur.myframework;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MyFrameworkTest {

    @Test
    public void testPremierAffichage() {
        // Création du mock object
        Application app = EasyMock.createStrictMock(Application.class);

        // Définition du scénario d'utilisation du mock
        EasyMock.expect(app.display()).andReturn("toto");
        EasyMock.expect(app.isFinish()).andReturn(true);

        // Préparation ed l'utilisation du mock
        EasyMock.replay(app);

        MyFramework framework = new MyFramework();
        framework.start(app);

        // vérification que le scénario est terminé
        EasyMock.verify(app);
    }

    @Test
    public void testUneSaisie() {
        // Création du mock object
        Application app = EasyMock.createStrictMock(Application.class);
        Supplier<String> in = EasyMock.createStrictMock(Supplier.class);

        // Définition du scénario d'utilisation du mock
        EasyMock.expect(app.display()).andReturn("affichage 1");
        EasyMock.expect(app.isFinish()).andReturn(false);
        EasyMock.expect(in.get()).andReturn("fin");
        app.receive("fin");
        EasyMock.expect(app.display()).andReturn("affichage 1");
        EasyMock.expect(app.isFinish()).andReturn(true);
        // Préparation ed l'utilisation du mock
        EasyMock.replay(app, in);

        MyFramework framework = new MyFramework();
        framework.setIn(in);
        framework.start(app);

        // vérification que le scénario est terminé
        EasyMock.verify(app);
    }

}