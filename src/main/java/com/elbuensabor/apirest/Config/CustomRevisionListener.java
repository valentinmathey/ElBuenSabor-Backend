package com.elbuensabor.apirest.Config;

import com.elbuensabor.apirest.Entity.Audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    //@Override
    public void newRevision(Object revisionEntity) {
        Revision revision = (Revision) revisionEntity;

        // Aquí puedes personalizar lo que se guarda en la revisión.
        // Por ejemplo, obtener el usuario actual o la IP
        revision.setUsername(getCurrentUsername());
        revision.setIpAddress(getCurrentIpAddress());
    }

    // Métodos para obtener usuario actual e IP, según tu contexto
    private String getCurrentUsername() {
        // Implementar lógica para obtener el nombre de usuario actual (e.g., de Spring Security)
        return "user";
    }

    private String getCurrentIpAddress() {
        // Implementar lógica para obtener la IP del request (e.g., usando HttpServletRequest)
        return "127.0.0.1";
    }
}
