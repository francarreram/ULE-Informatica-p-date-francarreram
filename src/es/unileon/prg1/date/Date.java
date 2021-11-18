package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) throws DateException {
		if ( year < 1) {
			throw new DateException("Date error: Year " + year + " not valid");
		}
		this.year = year;
	}

	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
    
	public boolean isSameYear(Date today){
		boolean isSame = false;

		if (this.year == today.getYear()){
			isSame = true;
		}
		
		return isSame;
	}

    public boolean isSameMonth(Date today){
        boolean isSame = false;

		if (this.month == today.getMonth()){
			isSame = true;
		}

		return isSame;
	}

	public boolean isSameDay(Date today){
        boolean isSame = false;

		if (this.day== today.getDay()){
			isSame = true;
		}

		return isSame;
	}

	public boolean isSame(Date today){
        boolean isSame = false;

		if (this.year == today.getYear() && this.month == today.getMonth() && this.day == today.getDay()){
			isSame = true;
		}

		return isSame;
	}
	
	public String monthName(){
		String monthName;

		switch(month){
			case 1:
				monthName = "Enero";
				break;
			case 2:
				monthName = "Febrero";
				break;
			case 3: 
				monthName = "Marzo";
				break;
			case 4:
				monthName = "Abril";
				break;
			case 5:
				monthName = "Mayo";
				break;
			case 6:
				monthName = "Junio";
				break;
			case 7:
				monthName = "Julio";
				break;
			case 8:
				monthName = "Agosto";
				break;
			case 9:
				monthName = "Septiembre";
				break;
			case 10:
				monthName = "Octubre";
				break;
			case 11:
				monthName = "Noviembre";
				break;
			default:
				monthName = "Diciembre";
		}

		return monthName;
	}

	public String seasonName(){

		String season = " ";

		switch(month) {
			case 1: 
			case 2:
			case 12:
				season = "Invierno";
				break;	
			case 3:
			case 4:
			case 5:
				season = "Primavera";
				break;
			case 6:
			case 7:
			case 8:
				season = "Verano";
				break;
			case 9:
			case 10:
			case 11:
				season = "Otoño";
				break;
		}

		return season;
	}

	public String monthsLeft(){

		StringBuffer meses = new StringBuffer();
		int month = this.month;
		Date fecha = this;

		for(int i = this.month; i < 12; i++){
			month++;
			meses.append(fecha.monthName() + " ");
		}

		return meses.toString();
	}

	public String monthsSame(){

		String meses = " ";

		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				meses = "January March May July August October December ";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				 meses = "April June September November ";
				break;
			default: 
				meses = "February ";
		}

		return meses;
	}

	public int daysPassed() throws DateException{

		int numeros = 0;

		if(this.getMonth() == 1 && this.getDay() != 1) {
			numeros += this.getDay()-1;
		}else {
			int mes = this.getMonth();
			for(int i = 1; i < this.month ; i++) {
				this.setMonth(i);
				numeros = numeros + this.getDaysOfMonth();
			}
			if(this.getDay() == 31 && mes == 12 ) {
				numeros = 365 - (getDaysOfMonth() - getDay())-1;
			}
		}
		return numeros;
	}

	public int randomDate(){

		int dia = 0;
		int mes = 0;
		int intentos = 0;
		
		do{
			dia = (int)((Math.random()*31)+1);
			mes = (int)((Math.random()*12)+1);
			intentos = intentos +1;
		}while((dia != this.day) && (mes != this.month));
		
		return intentos;
	}

	public int randomDate2(){

		int dia = 0;
		int mes = 0;
		int intentos = 0;

		while((dia != this.day) && (mes != this.month)){
			dia = (int)((Math.random()*31)+1);
			mes = (int)((Math.random()*12)+1);
			intentos = intentos + 1;
		}

		return intentos;
	}

	public String weekDay(int day) throws DateException {
		
		String dia = " ";
		int diaSemana = this.daysPassed() % 7;
		
		switch(diaSemana) {
			case 0:
				dia = "Monday";
				break;
			case 1:
				dia = "Tuesday";
				break;
			case 2:
				dia = "Wednesday";
				break;
			case 3:
				dia = "Thursday";
				break;
			case 4:
				dia = "Friday";
				break;
			case 5:
				dia = "Saturday";
				break;
			case 6:
				dia = "Sunday";
				break;
		}    
	    return dia;
	}
}