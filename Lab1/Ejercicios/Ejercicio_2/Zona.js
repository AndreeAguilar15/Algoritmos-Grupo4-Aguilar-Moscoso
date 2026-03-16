class Zona {
    constructor(tipoMineral, cantidad, pureza) {
        this._tipoMineral = tipoMineral;
        this._cantidad = cantidad;
        this._pureza = pureza;
    }
   
    getTipoMineral() {
        return this._tipoMineral;
    }
   
    getCantidad() {
        return this._cantidad;
    }
   
    getPureza() {
        return this._pureza;
    }
   
    calcularValorEconomico() {
        return this._cantidad * this._pureza;
    }
   
    toString() {
        return `[ ${this._tipoMineral}, cantidad: ${this._cantidad}, pureza: ${this._pureza} ]`;
    }
}

module.exports = Zona;

