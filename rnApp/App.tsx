import React from 'react';
import {NavigationContainer} from "@react-navigation/native"
import {createStackNavigator } from "@react-navigation/stack"
import {createBottomTabNavigator} from "@react-navigation/bottom-tabs"

import HomeScreen from "./screens/Home/HomeScreen"
import Menu from "./screens/Menu/Menu"

import LetterHuntMain from "./screens/Games/LetterHunt/index"
import CountingMainScreen from './screens/Games/Counting/index';
import ReadyMainScreen from './screens/Games/Ready/index';
import ImagineMainScreen from './screens/Games/Imagine/index';
import CountingActivityScreen from "./screens/Games/Counting/activity"
import NavBar from './components/NavBar';

const Stack = createStackNavigator()
const Tab = createBottomTabNavigator();

export default () => {
  return <NavigationContainer>
    <Stack.Navigator screenOptions={{
      headerShown: false
    }}>
      <Stack.Screen name="Home" component={HomeScreen} />
      <Stack.Screen name="Menu" component={Menu} />
      {/* Game Main Screens */}
      {/* Letter Hunt */}
      <Stack.Screen name="LetterHuntMain" component={LetterHuntMain} />

      {/* Counting */}
      <Stack.Screen name="CountingMain" component={CountingMainScreen} />
      <Stack.Screen name="CountingActivity" component={CountingActivityScreen} />

      {/* Dressing */}
      <Stack.Screen name="ReadyMain" component={ReadyMainScreen} />

      {/* Imagine Time */}
      <Stack.Screen name="ImagineMain" component={ImagineMainScreen} />
    </Stack.Navigator>
  </NavigationContainer>
}