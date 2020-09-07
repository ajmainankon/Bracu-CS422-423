import random

population = []
total = []
NumberOfQueens = 8
NumberOfQueensNotChallenging = NumberOfQueens*(NumberOfQueens-1)/2

# integar generation
def addPopulation(): 
    tempList = [] 
    
    for i in range (0, NumberOfQueens):
        tempList.append(random.randint(0, NumberOfQueens-1))
    population.append(tempList)

# fitness = the queens which are not challenging other queens    
def calculateFitness(list):
    count = 0
    val = []
    
    for i in range (0,NumberOfQueens):
        for j in range (i+1, NumberOfQueens):
            if(list[i] == list[j]):
                count = count + 1
                if list[i] not in val:
                    val.append(list[i])
            
            if((list[j] - list[i]) == (j - i)):
                count = count + 1
                if list[i] not in val:
                    val.append(list[i])

            if((list[i] - list[j]) == (j - i)):
                count = count + 1
                if list[i] not in val:
                    val.append(list[i])
    fitnessVal = NumberOfQueensNotChallenging-count
    
    return fitnessVal, val

# def select(population, fit):

    # take input:  population and fit
    # fit contains fitness values of each of the individuals 
    # in the population  
      
    # return:  one individual randomly giving
    # more weight to ones which have high fitness score'''
    # a = [0,1,2,3,4]
    # size = 2
    # p = [.31, .29]



# normal crossover where two lists are taken and split and then 
# exchanged values are returned as lists
def crossover(firstList, secondList):
    index = random.randint(0, NumberOfQueens-1)
    
    for i in range (0, index+1):
        firstList[i], secondList[i] = secondList[i], firstList[i]
    
    fitness, values = calculateFitness(firstList)
    if(fitness != NumberOfQueensNotChallenging):
        firstList = mutate(firstList, values)
    
    fitness, values = calculateFitness(secondList)
    if(fitness != NumberOfQueensNotChallenging):
        secondList = mutate(secondList, values)
    
    return firstList, secondList

# can change only one value or one bit 
def mutate(list, child):
    temporary = random.randint(0, len(child)-1)
    indexCount = list.index(child[temporary])
    tempVal = random.randint(0, NumberOfQueens-1)
    
    while(tempVal == child[temporary]):
        tempVal = random.randint(0, NumberOfQueens-1)
    list[indexCount] = tempVal
    
    return list



def GA():
    for i in range (0, NumberOfQueens):
        addPopulation()

    count = 0

    while(True):
        count = count + 1
        randomVal1 = random.randint(0, len(population)-1)
        randomVal2 = random.randint(0, len(population)-1)
        
        while randomVal2==randomVal1:
            randomVal2 = random.randint(0, len(population)-1)
    
        population[randomVal1], population[randomVal2] = crossover(population[randomVal1], population[randomVal2])
    
        fitness, values =  calculateFitness(population[randomVal1])
        
        if fitness == NumberOfQueensNotChallenging:
            total = population[randomVal1]
            break
    
        fitness, values =  calculateFitness(population[randomVal2])
        
        if fitness == NumberOfQueensNotChallenging:
            total = population[randomVal1]
            break
    
    print(total)


GA()