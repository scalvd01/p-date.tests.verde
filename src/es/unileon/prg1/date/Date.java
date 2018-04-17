package es.unileon.prg1.date;

import java.util.Random;//para el numero aleatorio




public class Date {
	private int day;
	private int month;
	private int year;
	
	
	
	
	//constructor con excepciones 
	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		
		
		if (year<0){
			throw new DateException("Año "+year+" no válido. Valores posibles positivos");
	}else{
		this.year=year;
	}
		if (month<1 || month>12){
				throw new DateException("Mes "+month+" no válido. Valores posibles entre 1 y 12");
		}else{
			this.month=month;
		}
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					if(day<1 || day>31){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					if(day<1 || day>30){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
			case 2:if(day<1 || day>28){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
		}
	}


	public Date tomorrow()  {
		Date tomorrow;
		tomorrow=new Date();
		try {
		
		this.month=getMonth();
		this.year=getYear();
		if(this.day == daysOfMonth()) {
			this.day=1;
			this.month++;
			if(this.month>12) {
				this.month=1;
				this.year++;
			}
		}else {
			this.day=1+getDay();
		}
		tomorrow=new Date(this.day,this.month,this.year);
		
		}catch(DateException e) {}
		return tomorrow;
	}




	public Date() {
		this.day=1;
		this.month=1;
		this.year=2017;
	}




	public Date(Date aDay) {
		this.day=aDay.getDay();
		this.month=aDay.getMonth();
		this.year=aDay.getYear();
	}

	 






	public void setYear(int year) throws DateException{
		if (year<0){
			throw new DateException("Año "+year+" no válido. Valores posibles positivos");
	}else{
		this.year=year;
	}
		
	}
	public int getYear(){
		return this.year;
	}
	public void setMonth(int month) throws DateException{
		if (month<1 || month>12){
			throw new DateException("Mes "+month+" no válido. Valores posibles entre 1 y 12");
	}else{
		this.month=month;
	}
		
	}
	public int getMonth(){
		return this.month;
	}
	public void setDay(int day) throws DateException{
		switch(this.month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
				if(day<1 || day>31){
						throw new DateException("Dia "+day+" no válido en el mes "+month);
	}else{
		this.day = day;
	}
				break;
		case 4:
		case 6:
		case 9:
		case 11:
				if(day<1 || day>30){
						throw new DateException("Dia "+day+" no válido en el mes "+month);
				}else{
					this.day = day;
				}
				break;
		case 2:if(day<1 || day>28){
						throw new DateException("Dia "+day+" no válido en el mes "+month);
				}else{
					this.day = day;
				}
				break;
		}
	}
	public int getDay(){
		return this.day;
	}
	



		//para comprobar si  dia mes y año son iguales en ambas fechas
	boolean isSameYear(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}
		

	boolean isSameMonth(Date another){
		if ( this.month == another.getMonth() ){
			return true;
		}
		return false;
	}


	boolean isSameDay(Date another){
		if ( this.day == another.getDay() ){
			return true;
		}
		return false;
	}
	//si todo es igual a la vez
	boolean isSame(Date another){
		if( this.year == another.getYear() && this.month == another.getMonth() && this.day == another.getDay()){
			return true;
		}
		return false;
	}






	//para el nombre del mes

	public String getMonthName(){

		String monthName=null;

		switch (this.month){

			case 1: monthName = "January";
					break;
			case 2: monthName = "February";
					break;
			case 3: monthName = "March";
					break;
			case 4: monthName = "April";
					break;
			case 5: monthName = "May";
					break;
			case 6: monthName = "June";
					break;
			case 7: monthName = "July";
					break;
			case 8: monthName = "August";
					break;
			case 9: monthName = "September";
					break;
			case 10: monthName = "October";
					break;
			case 11: monthName = "November";
					break;
			case 12: monthName = "December";
					break;
			default: monthName = "Mes inválido";
					break;
		}
		return monthName;
	}






	//para si el dia del mes esta bien

	public boolean isDayRight(){
		if (((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)) && ((this.day<=31) && (this.day>0))){
			return true;
		}
		else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11) && ((this.day<=30) && (this.day>0))){
			return true;
		}
		else if ((this.month==2) && ((this.day<=28) && (this.day>0))){
			return true;
		}
		else{
			return false;
		}
	}





	//para obtener las estaciones

	public String getSeasonName(){
		String seasonName=null;

		switch(this.month){
			case 1: seasonName = "Winter";
					break;
			case 2: seasonName = "Winter";
					break;
			case 3: if(this.day<21){
						seasonName = "Winter";
					}
					else{
						seasonName = "Spring";
					}
					break;
			case 4: seasonName = "Spring";
					break;
			case 5: seasonName = "Spring";
					break;
			case 6: if(this.day<20){
						seasonName = "Spring";
					}
					else{
						seasonName = "Summer";
					}
					break;
			case 7: seasonName = "Summer";
					break;
			case 8: seasonName = "Summer";
					break;
			case 9: if(this.day<21){
						seasonName = "Summer";
					}
					else{
						seasonName = "Autumn";
					}
					break;
			case 10:seasonName = "Autumn";
					break;
			case 11:seasonName = "Autumn";
					break;
			case 12:if(this.day<20){
						seasonName = "Autumn";
					}
					else{
						seasonName = "Winter";
					}
					break;
		}
		return seasonName;
	}






	//para imprimir los meses restantes hasta final de año

	public String getMonthsLeft(){
		StringBuilder months = new StringBuilder();
		int a = getMonth();
	
		for (int i = this.month+1; i<=12; i++){

			this.month = this.month + 1;
			months.append(this.getMonthName()+" ");
		}
		this.month=a;
		
		return months.toString();
	}
	




	//para imprimir la fecha

	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}





	//para imprimir todas las fechas hasta el final del mes

	public String getDaysLeftOfMonth(){
		StringBuilder daysLeft = new StringBuilder();
		
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					for(int dias = this.day+1; dias<=31; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					for(int dias = this.day+1; dias<=30; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
			case 2: for(int dias = this.day+1; dias<=28; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
		}
		
		return daysLeft.toString();
	}






	//para mostrar los meses con el mismo numero de dias que una fecha

	public String getMonthsSameDays(){
		String monthsSameDays=null;
		switch(this.month){

			case 1: monthsSameDays = "January March May July August October December ";
					break;
			case 2: monthsSameDays = "February ";
					break;
			case 3: monthsSameDays = "January March May July August October December ";
					break;
			case 4: monthsSameDays = "April June September November ";
					break;
			case 5: monthsSameDays = "January March May July August October December ";
					break;
			case 6: monthsSameDays = "April June September November ";
					break;
			case 7: monthsSameDays = "January March May July August October December ";
					break;
			case 8: monthsSameDays = "January March May July August October December ";
					break;
			case 9: monthsSameDays = "April June September November ";
					break;
			case 10: monthsSameDays = "January March May July August October December ";
					break;
			case 11: monthsSameDays = "April June September November ";
					break;
			case 12: monthsSameDays = "January March May July August October December ";
					break;
			
		}
		return monthsSameDays;
	}






	//para contar el num de dias que han pasado en una fecha

	public int daysPast(){
		int dias=0;


		switch(this.month){
			case 1: dias=dias+getDay();
					break; 
			case 2: dias=31+getDay();
					break; 
			case 3: dias=59+getDay();
					break;
			case 4: dias=90+getDay();
					break;
			case 5: dias=120+getDay();
					break;
			case 6: dias=151+getDay();
					break;
			case 7: dias=181+getDay();
					break;
			case 8: dias=212+getDay();
					break;
			case 9: dias=243+getDay();
					break;
			case 10: dias=273+getDay();
					break;
			case 11: dias=304+getDay();
					break;
			case 12: dias=334+getDay();
					break;
			
		}
		return dias-1;
	}





	//para el numero de intentos que tarda en acertar una fecha aleatoria

	public int numRandomTriesEqualDate(){
		int count=0;
		Random random=new Random();
		int randomDay=0;
		int randomMonth=0;


		while((this.day!=randomDay) || (this.month!=randomMonth)){
			if((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(32)+1;
				count=count+1;
			}
			else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(31)+1;
				count=count+1;
			}
			else if (this.month==2){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(29)+1;
				count=count+1;
			}
		}
		return count;

	}

	//lo mismo pero con do while

	public int numRandomTriesEqualDate2(){
		int count=0;
		Random random=new Random();
		int randomDay=0;
		int randomMonth=0;
		do{
			if((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(32)+1;
				count=count+1;
			}
			else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(31)+1;
				count=count+1;
			}
			else if (this.month==2){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(29)+1;
				count=count+1;
			}
		}while((this.day!=randomDay) || (this.month!=randomMonth));

		return count;
	}





	//para decir el dia de la semana de una fecha
	
	public String dayOfWeek(int num){
		String dia=null;
		num=(daysPast()+1)%7;
		
		//int resto = daysPast()%7;
		
		
			switch(num){
				case 1: dia="Monday";
						break; 
				case 2: dia="Tuesday";
						break; 
				case 3: dia="Wednesday";
						break;
				case 4: dia="Thursday";
						break;
				case 5: dia="Friday";
						break;
				case 6: dia="Saturday";
						break;
				case 0: dia="Sunday";
						break;
			}
		return dia;
	}




	




	public int daysOfMonth() {
		int dias=0;
		
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					dias=31;
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					dias=30;
					break;
			case 2: dias=28;
					break;
		}
		
		return dias;
	
	}







	







	
}

