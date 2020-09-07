import pygame
from pygame import gfxdraw
import math

# Drop Height and Width of the window
Height = 1280
Width = 720
# Drop your problem here // sample problems are Commented below
InitProblem = (10,10,60,50)
# InitProblem = (10,10,60,50)
# InitProblem = (10,-10,60,-50)
# InitProblem = (-30,-10,-100,-40)


def coord(x,y):
    return x+(int(Height/2)), y+(int(Width/2))

def findzone(x1, y1, x2, y2):
    delx = x2 - x1 
    dely = y2 - y1

    if abs(delx) > abs(dely):
        if (delx>0 and dely>0):
            return 0
        if (delx<0 and dely>0):
            return 3
        if (delx<0 and dely<0):
            return 4
        if (delx>0 and dely<0):
            return 7
    else:
        if (delx>0 and dely>0):
            return 1
            
        if (delx<0 and dely>0):
            return 2
                
        if (delx<0 and dely<0):
            return 5
                
        if (delx>0 and dely<0):
            return 6

def findXY(x, y, zone):
    if zone ==0:
        return x,y, zone
        return x,y
    if zone ==1:
        temp = x
        x = y
        y = temp
        return x,y
    if zone ==2:
        temp = x
        x = y
        y = -temp
        return x,y
    if zone ==3:
        x = -x
        return x,y
    if zone ==4:
        x = -x
        y = -y
        return x,y
    if zone ==5:
        temp = x
        x = -y
        y = -temp
        return x,y
    if zone ==6:
        temp = x
        x = -y
        y = temp
        return x,y
    if zone ==7:
        y = -y
        return x,y

def findInitialZone(x, y, zone):
    if zone ==0:
        return x,y
    if zone ==1:
        temp = x
        x = y
        y = temp
        return x,y
    if zone ==2:
        temp = x
        x = -y
        y = temp
        return x,y
    if zone ==3:
        x = -x
        return x,y
    if zone ==4:
        x = -x
        y = -y
        return x,y
    if zone ==5:
        temp = x
        x = -y
        y = -temp
        return x,y
    if zone ==6:
        temp = x
        x = y
        y = -temp
        return x,y
    if zone ==7:
        y = -y
        return x,y

Problem = (InitProblem[0], -InitProblem[1], InitProblem[2], -InitProblem[3])
InitalZone = findzone(Problem[0], Problem[1], Problem[2], Problem[3])

NewCord1 = findXY(Problem[0], Problem[1], InitalZone)
NewCord2 = findXY(Problem[2], Problem[3], InitalZone)
NewCoord1 = list(NewCord1)
NewCoord2 = list(NewCord2)

NewDelX = NewCoord2[0] - NewCoord1 [0]
NewDelY = NewCoord2[1] - NewCoord1 [1]
d = 2*NewDelY - NewDelX

pygame.init()                
screen = pygame.display.set_mode((Height, Width))
screen.fill((255,255,255))

pygame.display.set_caption("Sample")

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    while NewCoord1[0] !=  NewCoord2 [0]:
        
        if d <=0:
            EastIncrement = 2*NewDelY
            d = d + EastIncrement
            NewCoord1[0] += 1
        
        if d>0:
            NortEastIncrement = 2*NewDelY - 2*NewDelX
            d = d + NortEastIncrement
            NewCoord1[0] += 1
            NewCoord1[1] += 1
           
        init = findInitialZone(NewCoord1[0], NewCoord1[1], InitalZone)
        presentation = coord (init[0], init[1])

        gfxdraw.pixel(screen, presentation[0], presentation[1], (0,0,0))
    
    pygame.display.update()
