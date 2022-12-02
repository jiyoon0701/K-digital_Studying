#
#1.
# x=c(2, -1, 3, 7, 0.5, 8)가 실행되었다 하자. 다음 물음을 R 언어로 답하시오.
#
#①6, 2, 4번째 원소를 동시에 찾아라.
#②x의 원소 중 0보다 큰 값을 찾아라.
#③짝수 원소들을 찾아라.
#④x에서 홀수원소를 찾아 제거하라.
#

x=c(2, -1, 3, 7, 0.5, 8) #벡터 데이터 
x
#①
x[c(6, 2, 4)] #[인덱스].R에서는 인덱스 1부터 시작
#②
x[x>0]  #요소의 조건을 인덱스로 사용
#③
x[x%%2==0]
#④
x[x%%2==1]=NA
x
#2.
# 다음과 같은 번호(ID), 성명(name), 성적(score)를 성분으로 하는 리스트가 있다.
# 물음에 답하라.
# L=list(ID=c(1,2,3), 
#      name=c('Kim', 'Lee', 'Park'),
#       score=c(80, 95, 75))
# ① length(L)은 얼마이며, 이것은 무엇을 의미하는가?
# ② 이름 성적 75을 80으로 수정하라.
# ③ L$name=='Park'의 결과를 쓰고, 무엇을 의미하는지 설명하라.
# ④ L$score[L$name=='Park']의 결과를 쓰고, 문장이 무엇을 의미하는지 설명하라.
# ⑤ 1번 학생의 이름과 성적을 알아내는 문장을 만들어 보아라.
L=list(ID=c(1,2,3), 
       name=c('Kim', 'Lee', 'Park'),
       score=c(80, 95, 75))
L 
#①
length(L)   #열의 갯수. 데이터의 종류의 갯수
#②
L$name[L$score==75]
L[L$score==80] #조건으로 인덱스 선택

L$score[L$score==75]=80
L$score

#③
L$name=='Park'  #name이 Park여부 boolean으로 출력
#④
L$score[L$name=='Park'] #Park의 성적만 조회
#⑤
cat(L$name[L$ID==1], L$score[L$ID==1]) #cat : 화면에 여러개의 변수 출력
union(L$name[L$ID==1], L$score[L$ID==1]) #union : 두개의 데이터를 합한객체
c(L$name[L$ID==1], L$score[L$ID==1])


##### matrix를 이용하여 햄버거 영양 데이터 분석
#byrow=T : 행우선으로 데이터 설정
burger <- matrix(c(514,917,11,533,853,13,566,888,10),nrow=3,byrow=T) 
burger
#행,열의 이름 지정
rownames(burger)<-c('M','L','B')
colnames(burger)<-c('kcal','na','fat')
#M사의 나트륨 함량 조회
burger['M','na']  #matrix[행,열]
#M사의 데이터 조회
burger['M',] #matrix[행,]
#모든 회사의 kcal 데이터 조회
burger[,'kcal']

##### dataframe을 이용한 햄버거 영양 성분 분석
kcal <- c(514,533,566)
na <- c(917,853,888)
fat <- c(11,13,10)
menu <-c('새우','불고기','치킨')
burger <- data.frame(kcal,na,fat,menu)
burger

#행의이름 설정
rownames(burger) <-c('M',"L",'B')
burger
#M사의 na 값 조회
burger['M','na']
#M사의 모든값 조회
burger['M',]
#모든 회사의 kcal값 조회
burger[,'kcal']

#'M','B' 회사의 menu값 조회
burger[c('M','B'),'menu']

#'M','B' 회사의 menu,kcal값 조회
burger[c('M','B'),c('menu','kcal')]

### R에서 제공해주는 iris 데이터 이용하기
iris

head(iris) #처음 6개의 데이터만 출력
tail(iris) #마지막 6개의 데이터만 출력

#행,열의 갯수
dim(iris) #행열의 갯수
nrow(iris) #행의 갯수
ncol(iris) #열의 갯수
colnames(iris)
str(iris)  #dataframe 데이터의 요약 정보

#iris 데이터의 품종만 조회
iris[,'Species']  #컬럼명으로 조회
iris[,5]  #컬럼의 순서(인덱서)로 조회
levels(iris[,5])
#품종별 데이터 건수 
table(iris[,5])
#5번컬럼을 제외하고 조회
iris[,-5]
#5번컬럼을 제외하고, 열별 합계 조회하기
colSums(iris[,-5])
#5번컬럼을 제외하고, 열별 평균 조회하기
colMeans(iris[,-5])
#5번컬럼을 제외하고, 행별 합계 조회하기
rowSums(iris[,-5])
#5번컬럼을 제외하고, 행별 평균 조회하기
rowMeans(iris[,-5])
#품종이 setosa인 데이터만 iris1에 저장하기
iris1 <- subset(iris,Species=='setosa')
iris1
str(iris1)
levels(iris1[,5])

#Sepal.Length > 5 이고, Sepal.Width>4인 행만 iris2에 저장하기
iris2<-subset(iris,Sepal.Length > 5 & Sepal.Width > 4)
iris2

#열 조회하기 
# Sepal.Length > 5 크고,Sepal.Width > 4보다 큰 행의 
# Petal.Length Petal.Width Species 컬럼만 조회하기
iris2[,c(3,4,5)]
iris2[,c('Petal.Length', 'Petal.Width', 'Species')]
iris2[,c(3:5)]  #c(3:5) : 3~5까지의 숫자값들. 3,4,5
subset(iris,Sepal.Length > 5 & Sepal.Width > 4)[,c(3,4,5)]

sum(iris[,1]) #1열의 합
mean(iris[,1]) #1열의 평균
max(iris[,1]) #1열의 최대값
min(iris[,1]) #1열의 최소값
#iris 데이터의 자료형
class(iris)
is.data.frame(iris)
is.matrix(iris)

#미국의 주의 정보 : state.x77
state.x77
class(state.x77)
state <- data.frame(state.x77) # data.frame <- matrix 변환
class(state)

# trees 데이터를 이용한 데이터 추출
trees
# 직경의 평균값 구하기
mean(trees[,1])
mean(trees[,'Girth'])
mean(trees$Girth)
str(trees)
#① 직경(Girth)은 화원에서 보유한 벚나무의 평균보다 커야 한다
tree1 <- subset(trees,Girth > mean(trees$Girth))
tree1
nrow(tree1)
#① 직경(Girth)은 화원에서 보유한 벚나무의 평균보다 커야 한다
#② 높이(Height)는 80보다 커야 한다.
#③ 부피(Volume)는 50보다 커야 한다.
# 3가지를 모두 만족하는 나무의 갯수 출력하기
result <- subset(trees,Girth > mean(trees$Girth) & Height > 80 & Volume > 50)
result
nrow(result)

###### 종업원의 팁 자료형 분석하기 : reshape2 패키지에 저장된 데이터임
tips 
#reshape2 패키지 설정하기
install.packages('reshape2')
library(reshape2)  #설정된 패키지 사용하기.
tips
.libPaths()  #패키지가 설정된 폴더 조회하기. 폴더에 한글경로 안됨.
#.libPaths(한글이름없는 폴더로 다시 지정) #패키지경로 설정 

class(tips)
str(tips)
#   total_bill : 전체 결제금액
#   tip        : 팁금액
#   sex        : 성별
#   smoker     : 흡연여부
#   day        : 요일.
#   time       : 점심/저녁
#   size       : 인원수

head(tips)
#요일별 팁을 받은 갯수를 조회하기
tips$day
table(tips$day)
table(tips[,5])
table(tips[,"day"])

#시간별 팁을 받은 갯수를 조회하기
table(tips$time)

# 시간대별로 Dinner 인경우만 조회하여  dinner 데이터에 저장하고,
# Lunch 인 경우만  lunch  데이터에 저장하기
dinner <- subset(tips,time=='Dinner')
lunch <- subset(tips,time=='Lunch')
dinner
lunch

# dinner와 lunch 데이터 셋에서 결제금액,팁,인원수의 평균구하기
# colMeans()
colMeans(dinner[c('total_bill','tip','size')])
colMeans(lunch[c('total_bill','tip','size')])

#결제금액 대비 팁의 비율조회하기
tips$tip/tips$total_bill
#결제금액 대비 팁의 비율이 높은 값하기
max(tips$tip/tips$total_bill)
#결제금액 대비 팁의 비율이 낮은 값하기
min(tips$tip/tips$total_bill)
mean(tips$tip/tips$total_bill)

#dinner,lunch 데이터의 팁의 비율의 평균 조회하기
mean(dinner$tip/dinner$total_bill)
mean(lunch$tip/lunch$total_bill)

#시각화
y2017 <- c(116215, 3437, 26183, 7522, 147, 1411)
y2016 <- c(104359, 3393, 24527, 7058, 102, 975)
#rbind : 행을 연결
df<-rbind(y2017,y2016)
df
class(y2017)
class(df)
# 컬럼이름 설정하기 
colnames(df) <- c('시','소설','수필','평론','희곡','기타')
df

#막대 그래프
barplot(df, main = '문인잡지의 작품 발표 현황',
        xlab = '작품 종류',
        ylab = '발표 건수',
        col = c('maroon', 'indianred'),  #색상 
        legend.text = c('2017', '2016'))

barplot(df, main = '문인잡지의 작품 발표 현황',
        xlab = '작품 종류',
        ylab = '발표 건수',
        col = c('maroon', 'indianred'),
        legend.text = c('2017', '2016'),beside=T)

### 히스토그램 : 자료의 분포를 시각화
cars  #제동거리 
dist <- cars[,2]
dist
hist(dist)
#breaks=12 : 값의 구간을 12개 분리 
hist(dist,breaks=12)

h<- 
  hist(dist,main='Histogram for 제동거리',breaks=6)
h
#h$breaks : 값의 구간값
#h$counts : 값의 구간별 빈도수(갯수). 막대의크기 
#h$density : 밀도값.
#h$mids   : 중간값
#h$xname : 데이터의 이름 
#h$equidist : 그래프간격이 일정?

h<- 
  hist(dist,main='Histogram for 제동거리',breaks=12)
h$breaks
h$counts

h<- 
  hist(dist,main='Histogram for 제동거리',breaks=10)
h$breaks

install.packages('Stat2Data')
library(Stat2Data)
data("Diamonds")
str(Diamonds)
head(Diamonds)

#캐럿당 가격의 분포를 히스토그램으로 출력하기
h<-hist(Diamonds$PricePerCt,main="캐럿당가격의분포")
h$breaks
h$counts

#색상설정
color <- rep('orange',9) #
color
#캐럿당 가격의 분포를 히스토그램으로 출력하기
h<-hist(Diamonds$PricePerCt,main="캐럿당가격의분포",
        xlab='캐럿당가격',ylab="빈도수", col=color)
h<-hist(Diamonds$PricePerCt,main="캐럿당가격의분포",
        xlab='캐럿당가격',ylab="빈도수", col='blue')

#캐럿당 가격의 분포를 히스토그램으로 출력하기
# 빈도수가 많은 막대 색상을 red로 변경
#which.max(h$counts) : 
#  h$counts 데이터 중 가장큰값의 인덱스를 리턴
color[which.max(h$counts)] <- 'red'
color[3] <- 'yellow'
h<-hist(Diamonds$PricePerCt,main="캐럿당가격의분포",
        xlab='캐럿당가격',ylab="빈도수", col=color)
