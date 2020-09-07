import pandas as pd
import random
import numpy as np


global n 
n = 8    

# def initialize(N):

population1 = np.random.randint(10, size=(n,n))
# print (population1)
    
def fitness(population, n):
    Maximum_Number_of_Pairs = (n*(n-1))/2
    y = population.tolist()
    # print (y)
    for i,j in zip(list(population)):  
        if i == j:
            print ("Hello")
        # if y.count(z) > 1:
        #     print ("Yes")
    # Fitness = Maximum_Number_of_Pairs - Attacking_Pairs 



fitness (population1, 8)