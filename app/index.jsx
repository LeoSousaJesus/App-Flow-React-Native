import { useState } from "react";
import { Image, Pressable, StyleSheet, Text, View } from "react-native";
import {FlowButton} from "../components/FlowButton";
import {ActionButton} from "../components/ActionButton";
import {FlowFooter} from "../components/FlowFooter";
import {Timer} from "../components/Timer";

export default function Index() {
  /* meu primeiro Hook */
  /* timerType - tipo*/
  const [timerType,setTimerType] = useState(pomodoro[2]) 
  return (
    <View style={styles.container}>
      <Image source={timerType.image} />
      <View style={styles.actions}>
         <View style={styles.context}>
             {pomodoro.map(p =>(
                  <ActionButton 
                      key={p.id}
                      active={ timerType.id === p.id }
                      onPress={() => setTimerType(p)}
                      display={p.display}/>    
             ))}                   
         </View>
         <Text style={styles.timer}>
              {new Date(timerType.initialValue * 60000).toLocaleTimeString('pt-BR',{minute:'2-digit',second:'2-digit'})}
         </Text> 
         <FlowButton />
         {/* <Pressable style={styles.button} >
            <Text style={styles.buttonText}>
               Começar
            </Text>
         </Pressable>        */}
      </View>
      <FlowFooter />
    </View>
  );
}

const styles = StyleSheet.create({
     
     container:{
        flex:1,
        justifyContent:"center",
        alignItems:"center",
        backgroundColor:'#021123',
      
     },
     actions: {
        
        paddingVertical: 24,
        paddingHorizontal: 24,
        backgroundColor: '#14448080',
        width: "80%",
        borderRadius: 32,
        borderWidth: 2,
        borderColor: '#144480',   
        gap: 40,      
     },
     timer: {
        fontSize: 54,
        color: '#FFF',
        fontWeight: 'bold',
        textAlign: 'center'
     },
     context:{
       flexDirection: 'row',
       justifyContent: 'space-around',
       alignItems:'center'
     },
});

const pomodoro = [

    {
      id:'focus',
      initialValue:25,
      image:require('./pomodoro.png'),
      display:'FOCUS'
    },
    {
      id:'short',
      initialValue:5,
      image:require('./short.png'),
      display:'SHORT'
    },
    {
      id:'long',
      initialValue:15,
      image:require('./long.png'),
      display:'LONG'
    }

]
/*export default App;*/