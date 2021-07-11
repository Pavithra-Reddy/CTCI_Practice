/*
* DrawLine - sets bit in positions given
*/
import java.util.*;
class DrawLine{
  public static void main(String args[]){
    byte[] screen = {0,0, 0,0, 0,0};
    drawLine(screen, 16, 2, 10, 1);
    for(byte b: screen){
      System.out.println(b);
    }
  }
  private static void drawLine(byte[] screen, int width, int x1, int x2, int y){
    int startOffset = x1%8;
    int startFull = x1/8;
    int endOffset = x2%8;
    int endFull = x2/8;

    if(startOffset != 0){
      startFull++;
    }

    if(endOffset != 7){
      endFull--;
    }

    for(int i = startFull; i <= endFull; i++){
      screen[(width/8)*y + i] = (byte) 0xff;
    }

    byte startMask = (byte) (0xff >> startOffset);
    byte endMask = (byte) ~(0xff >> endOffset + 1);

    if(x1/8 == x2/8){
      screen[(width/8)*y + (x1/8)] |= (startMask & endMask);
    } else {
      screen[(width/8)*y + startFull - 1] |= (startMask);
      screen[(width/8)*y + endFull + 1] |= (endMask);
    }

  }
}
