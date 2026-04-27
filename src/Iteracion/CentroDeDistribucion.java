package Iteracion;

import java.util.PriorityQueue;
import java.util.HashSet;

public class CentroDeDistribucion {
    private PriorityQueue<Paquete<?>> filaPaquetes;
    private HashSet<String> controlDeIds; 
    
    public CentroDeDistribucion() {
        this.controlDeIds = new HashSet<>();
        this.filaPaquetes = new PriorityQueue<>((p1, p2) -> {
            boolean p1EsPrioridad = p1.isUrgente() || p1.getPeso() > 50;
            boolean p2EsPrioridad = p2.isUrgente() || p2.getPeso() > 50;

            if (p1EsPrioridad && !p2EsPrioridad) {
                return -1; 
            } 
            else if (!p1EsPrioridad && p2EsPrioridad) {
                return 1; 
            }
            else {
                return 0; 
            }
        });
    }

    public void recibirPaquete(Paquete<?> nuevoPaquete) {
        if (controlDeIds.add(nuevoPaquete.getId())) {
            filaPaquetes.add(nuevoPaquete);
            System.out.println("Paquete " + nuevoPaquete.getId() + " ingresado al sistema.");
        } else {
            throw new IllegalArgumentException("El ID '" + nuevoPaquete.getId() + "' ya está registrado en el sistema.");
        }
    }
    
    public Paquete<?> procesarSiguientePaquete() {
        if (!filaPaquetes.isEmpty()) {
            return filaPaquetes.poll();
        } else {
            System.out.println("No hay paquetes para procesar.");
            return null;
        }
    }
}
