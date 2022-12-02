#작업용 폴더 설정
setwd("d:/20220811/r/workspace/수업소스")
getwd() #현재 작업 폴더 
print(1+2)
1+2
print(3,4) #콘솔출력. 한개만
cat(3,4)   #콘솔출력. 여러개를 ,연결하여 출력 

1+2

## 산술연산자
5/2   #2.5.   /:나누기 결과값
5%/%2   #2   %/% : 나누기 몫만 정수로 
3^3   #제곱
3**3  #제곱
5%%2  #나머지

1+2
'1'+'2'  #문자형의 + 연산자 사용 불가

as.numeric('1')+as.numeric('2')  #as.numeric(문자) => 숫자

# 결측값 : NA
sum(1,2,3) #sum : 데이터의 합
sum(1,2,NA) #NA 
sum(1,2,NA,na.rm=T) #NA를 제외하고 합.na.rm=T : NA값을 제외 

# Factor 자료형 : 범주를 가지고 있는 자료형 
#                 범주를 R에서는 level이라고도 함
data <- c(3,2,2,1,1,2,3,3,2) #벡터 자료형 
data
factor(data) #값의 범위 

#파일 읽기
txt1 <- read.csv("factor_test.txt")
txt1
#혈액형 출력
txt1$blood
##혈액형 종류 만 출력
b<-factor(txt1$blood)
b
summary(b)  #값의 건수를 표로 생성 함수 

#남자,여자의 인원수 출력
s <-factor(txt1$sex)
s
summary(s)

### Data Object : 데이터의 모임. 
# 
#  vector : 데이터를 한줄로 모아주는 객체
#           c(1,2,3) 벡터 생성 함수 


#  matrix : 표 형태의 데이터. 
#           행과 열로 이루어진 데이터.
#           dataframe 

#  array  : 배열. 1차원 ~ n차로 데이터 저장 객체
#  list   : 객체를 한줄로 모아 줄 수 있는 객체
#
#####  Data Object 내부에 저장된 데이터의 자료형. 
# 1.숫자형 (numeric)
#     - 정수(integer) : 소숫점이하 없는 수.
#     - 실수(double)  : 소숫점을 저장할 수 있는 자료형
#     - 복소수(complex) 
# 2.문자형(character) : ", '  로 표현가능
#     "abc:, 'abc'
# 3.논리형 (logical)
#     - 참 (TRUE,T,수표현:1)
#     - 거짓 (FALSE,F,수표현:0) 
# 4. 날짜형(date)
#     - 내부적으로 숫자저장되지만, 표현은 문자형태의 날짜로 표현.

typeof(txt1)

a<- c(1,2,3)  #벡터
typeof(a) #요소의 자료형
mode(a)
length(a)
# dataframe X 정의하기
# 1:9 : 1 ~ 9까지의 숫자
#nrow=3 : 행의 갯수 3개. 3행. 열의 갯수는 3열 설정.
#dimnames(행의이름,열의이름)
x <- matrix(1:9,nrow=3,
           dimnames=list(c('r1','r2','r3'),c('c1','c2','c3')))
1:9
x
