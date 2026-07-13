package notificacionDePedido;

import pedido.*;

public class GeneradorDeFactura implements ObservadorPedido {

    private Comprobante comprobante;

    public GeneradorDeFactura(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public void actualizar(Pedido pedido, EstadoPedido estado) {

        if (estado instanceof Entregado) {
            comprobante.crearComprobanteFiscal();
        }
    }
}