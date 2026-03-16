const fs = require('fs');
const readline = require('readline');
const Zona = require('./Zona');
const Terreno = require('./Terreno');
const AnalizadorMinero = require('./AnalizadorMinero');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

class Principal {
   
    static preguntar(pregunta) {
        return new Promise((resolve) => {
            rl.question(pregunta, (respuesta) => {
                resolve(respuesta);
            });
        });
    }
   
    static async leerDatosDesdeArchivo(nombreArchivo) {
        try {
            const data = fs.readFileSync(nombreArchivo, 'utf8');
            const lineas = data.split('\n').filter(linea => linea.trim() !== '');
           
            const [filas, columnas] = lineas[0].split(' ').map(Number);
           
            const terreno = new Terreno(filas, columnas);
           
            let indice = 1;
            for (let i = 0; i < filas; i++) {
                for (let j = 0; j < columnas; j++) {
                    if (indice < lineas.length) {
                        const partes = lineas[indice].trim().split(' ');
                        const tipoMineral = partes[0];
                        const cantidad = parseFloat(partes[1]);
                        const pureza = parseFloat(partes[2]);
                       
                        const zona = new Zona(tipoMineral, cantidad, pureza);
                        terreno.agregarZona(i, j, zona);
                       
                        indice++;
                    }
                }
            }
           
            return terreno;
           
        } catch (error) {
            console.error("Error al leer el archivo:", error.message);
            return null;
        }
    }
   
    static crearArchivoEjemplo() {
        const contenido = `3 3
Oro 10 0.9
Plata 8 0.85
Cobre 12 0.7
Oro 6 0.92
Oro 4 0.88
Plata 7 0.8
Cobre 9 0.75
Oro 5 0.9
Plata 6 0.82`;
       
        fs.writeFileSync('datos.txt', contenido);
        console.log("Archivo 'datos.txt' creado con datos de ejemplo.");
    }
   
    static async main() {
        try {
            console.log("=".repeat(60));
            console.log("ANÁLISIS DE ZONA MINERA");
            console.log("=".repeat(60));
           
            if (!fs.existsSync('datos.txt')) {
                console.log("No se encontró el archivo 'datos.txt'");
                const crear = await this.preguntar("¿Desea crear un archivo de ejemplo? (s/n): ");
               
                if (crear.toLowerCase() === 's') {
                    this.crearArchivoEjemplo();
                } else {
                    console.log("Programa terminado.");
                    rl.close();
                    return;
                }
            }
           
            const terreno = await this.leerDatosDesdeArchivo('datos.txt');
           
            if (!terreno) {
                console.log("No se pudo cargar el terreno.");
                rl.close();
                return;
            }
           
            console.log("\nTerreno cargado:");
            terreno.mostrarTerreno();
           
            const kInput = await this.preguntar(`\nIngrese el tamaño de la subregión a analizar (k): `);
            const k = parseInt(kInput);
           
            if (isNaN(k) || k <= 0) {
                console.log("Tamaño inválido. Debe ser un número positivo.");
                rl.close();
                return;
            }
           
            console.log(`\nAnalizando subregiones de ${k}x${k}...`);
            const resultado = AnalizadorMinero.encontrarRegionMasValiosa(terreno, k);
           
            AnalizadorMinero.mostrarResultados(resultado);
           
        } catch (error) {
            console.error("Error:", error.message);
        } finally {
            rl.close();
        }
    }
}

Principal.main();
