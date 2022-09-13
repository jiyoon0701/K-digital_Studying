package chap11;
/*
 * I am honored to be with you today at your commencement 
 * from one of the finest universities in the world. 
 * I never graduated from college. Truth be told, 
 * this is the closest I've ever gotten to a college graduation. 

 * 문자 중에서 ‘a'부터 ’z'까지가 각각 몇 개 존재하는지 비율을 조사하시오.
 * 단 대문자는 소문자로 인식하여 처리한다.
 [결과]
a -> 8 ,  3.756%
b -> 2 ,  0.939%
c -> 5 ,  2.347%
d -> 7 ,  3.286%
e -> 25 , 11.737%
f -> 4 ,  1.878%
g -> 5 ,  2.347%
h -> 7 ,  3.286%
i -> 12 ,  5.634%
j -> 0 ,  0.000%
k -> 0 ,  0.000%
l -> 7 ,  3.286%
m -> 6 ,  2.817%
n -> 10 ,  4.695%
o -> 19 ,  8.920%
p -> 0 ,  0.000%
q -> 0 ,  0.000%
r -> 11 ,  5.164%
s -> 7 ,  3.286%
t -> 20 ,  9.390%
u -> 6 ,  2.817%
v -> 4 ,  1.878%
w -> 2 ,  0.939%
x -> 0 ,  0.000%
y -> 3 ,  1.408%
z -> 0 ,  0.000%

 */
public class Test10 {
	public static void main(String[] args) {
		String msg = 
	"I am honored to be with you today at your commencement "
	+ "from one of the finest universities in the world. "
	+ "I never graduated from college. Truth be told, "
	+ "this is the closest I've ever gotten to a college graduation.";
		msg = msg.toLowerCase();
		int chcnt=0;
		int cnt[]=new int[26];
		char ch;
		for(int i=0; i<msg.length( ); i++) {
		  if(msg.charAt(i)>='a'&& msg.charAt(i)<='z') {
		     cnt[msg.charAt(i)-'a']++;
		     chcnt++;
		  }   
		}   
		for(int i=0; i<26; i++){
		     ch=(char)('a'+i);
		     System.out.printf
		     ("%c -> %d , %6.3f%c\n",ch,cnt[i],(cnt[i]*100.0/chcnt),'%');
		     System.out.println
		     (ch+" => "+cnt[i] +" , " + String.format("%6.3f",cnt[i]*100.0/chcnt)+'%');
	      }
	}
}
