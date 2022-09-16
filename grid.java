
int blockAct = 0;
int fall =0;
int col = 32;
int row = 32;
int shift =0; 
int next = 0;
int stepX, stepY;
int randomizer = (int) random(32);// randomizer that randomly places a block somewhere on  the x axis at the very top of the page
public int check =0;
void setup(){
  
  size(500,500);

  stepX = width / col;
  stepY =  height / row;
 //noLoop();
 frameRate(60);
  
}
int arr[][] = new int[33][33]; // an Array of all the grid squares

void draw(){
  
   
  for(int i =0; i< col; i++){
    
    for(int j = 0 ; j<row;j++){
      
      float x = i * stepX; //move to the right
      float y = j * stepY; // move down
     
      
      if(arr[i][j] ==1){ // This-if statement re-Fills in any square that has a black block placed 
        fill(0,0,0);
        rect(x,y,stepX,stepY);
      }
      else{
         fill(1,100,40);
     rect(x,y,stepX,stepY);
      }
   
       
    }
   
    
    
    
  }
 for(int k =0; k<col;k++){
  
for(int l = 0; l<row-4;l++){
  
  int g = k*stepX;
  int h = l*stepY;
  if((l<3+shift && l>=shift) || (l>=6+shift && l <9+shift) || (l>=12+shift && l<15+shift) || (l>=18+shift && l<21+shift)|| (l>=24+shift && l<27+shift) || (shift >=3  && l<shift-3)){  // This if statement creates 3 rows of yellow stripes every 3 grids 
   
   if(arr[k][l] != 1){ fill(255,255,0); // This if-statement checks to see if the square doesn't have a block placed in order to allow the grid to move in a way so that the blocks don't get removed while the canvas is changing
    rect(g,h,stepX,stepY);}
   
  }
  else{ // This else creates 3 rows of blue stripes every 3 grid points
  
  
   if(arr[k][l] != 1){ fill(0,181,226); // This if-statement checks to see if the square doesn't have a block placed in order to allow the grid to move in a way so that the blocks don't get removed while the canvas is changing
     rect(g,h,stepX,stepY);
   }
    
  }
    
  
}
for(int p =row-4;p<row;p++){ // The ground 
  int z = k*stepX;
  int q = p*stepY;
  fill(0,0,0);
  rect(z,q,stepX,stepY);
}

 }
fill(0,0,0);

rect(randomizer*stepX,fall*stepY,stepX,stepY);// Displays the block


 fall++; // Allows the block to fall each time the draw method loops
 if(fall==27 || arr[randomizer][fall+1] ==1){ // checks to see if the block has hit the ground (or hit other block while falling)
     arr[randomizer][fall] = 1; // Assigns the cordinate with a 1 so that we know the square has a block placed at it
   fall =0;  
   next =1;
  
   randomizer = (int) random(33); // Re-generates another cordinate x
  
 }
  shift++; // allows the grid stripes to move
  if(shift ==6) shift =0; // Allows the grid to loop back to it's original position
}
