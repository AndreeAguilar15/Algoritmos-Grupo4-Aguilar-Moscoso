const Zona = require('./Zona');

class Terreno {
    constructor(filas, columnas) {
        this._filas = filas;
        this._columnas = columnas;
        this._matriz = [];
       
        for (let i = 0; i < filas; i++) {
            this._matriz[i] = new Array(columnas);
        }
    }
   
    agregarZona(fila, columna, zona) {
        if (fila >= 0 && fila < this._filas && columna >= 0 && columna < this._columnas) {
            this._matriz[fila][columna] = zona;
            return true;
        }
        return false;
    }
   
    getZona(fila, columna) {
        if (fila >= 0 && fila < this._filas && columna >= 0 && columna < this._columnas) {
            return this._matriz[fila][columna];
        }
        return null;
    }
   
    getFilas() {
        return this._filas;
    }
   
    getColumnas() {
        return this._columnas;
    }
   
    mostrarTerreno() {
        console.log("Terreno completo:");
        for (let i = 0; i < this._filas; i++) {
            let filaStr = "";
            for (let j = 0; j < this._columnas; j++) {
                if (this._matriz[i][j]) {
                    filaStr += `[${this._matriz[i][j].getTipoMineral()}] `;
                } else {
                    filaStr += "[Vacío] ";
                }
            }
            console.log(filaStr);
        }
    }
}

module.exports = Terreno;

