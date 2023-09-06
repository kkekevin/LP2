public enum Etapa {
    Pedido {
        @Override
        public Etapa getNextStep() {
            return Preparando;
        }
    },
    Preparando {
        @Override
        public Etapa getNextStep() {
            return Entregue;
        }
    }, 
    Entregue {
        @Override
        public Etapa getNextStep() {
            return Entregue;
        }
    };

    public abstract Etapa getNextStep();
}
