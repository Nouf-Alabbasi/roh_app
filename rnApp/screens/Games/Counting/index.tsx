import React, { useMemo } from "react";
import { Text, TouchableOpacity } from "react-native";
import { StyleSheet } from "react-native";
import { View } from "react-native";
import NavBar from "../../../components/NavBar";
import { SCREEN_PADDING } from "../../../variables";

const CountingMainScreen = ({ navigation }: { navigation: any }) => {
  let tenNums: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  const handleSelection = (number: number) => {
    navigation.navigate("CountingActivity", {
      option: number,
    });
  };

  return (
    <View style={styles.root}>
      <Text>Counting Menu</Text>
      {tenNums.map((num) => {
        return (
          <TouchableOpacity
            onPress={() => handleSelection(num)}
            style={styles.button}
          >
            <Text style={{ textAlign: "center", fontSize: 50 }}>{num}</Text>
          </TouchableOpacity>
        );
      })}
      <NavBar />
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    paddingTop: SCREEN_PADDING,
    flex: 1,
    justifyContent: "space-between",
  },
  button: {
    borderColor: "red",
    borderWidth: 3,
    padding: 10,
    borderRadius: 50,
    justifyContent: "center",
  },
});

export default CountingMainScreen;
