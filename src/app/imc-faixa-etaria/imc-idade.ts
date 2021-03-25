
export class Imc  {
    faixa: string = '';
    media: string = '';

    constructor(faixa: string, media: number) {
        this.faixa = faixa;
        this.media =  media.toFixed(2); 
    }
}