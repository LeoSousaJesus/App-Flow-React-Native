import { Image, Pressable, StyleSheet, Text, View } from "react-native";

export default function Index() {
  return (
    <View style={styles.container}>
      <Image source={require('./pomodoro.png')} />
      <View style={styles.actions}>
      <Text style={styles.timer}> 
          25:00
      </Text>
        <Pressable style={styles.button}>
          <Text style={styles.buttonText}>
            Começar
          </Text>
        </Pressable>
        <View style={styles.footer}>
          <Text style={styles.footerText}>
            Desenvolvido por Leandro Sousa
          </Text>
        </View>
      </View>
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
        width: "900px",
        height: "200px",
        borderRadius: 32,
        borderWidth: 2,
        borderColor: '#144480',   
        gap: 40,      
     },

     timer:{

      fontSize: 54,
      color: '#FFF',
      fontWeight: 'bold',
      textAlign: 'center'
     },

     buttonText:{

      textAlign: 'center',
      color: '#021123',
      fontSize: 18
     },

     button:{

      backgroundColor:"#B872FF",
      borderRadius: 32,
      padding: 10
     },

     footer:{

        width:'80%',
     },

     footerText:{
      
      textAlign: 'center',
      color: '#98A0A8',
      fontSize:12.5

     }

});