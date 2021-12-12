import React from 'react';
import { AppBar, Toolbar, Typography, Box, } from '@material-ui/core';
import "./NavBar.css"

function Navbar() {
    return (
        <>

            <AppBar position="static"  >
                <Toolbar variant="dense" className= "color-nav container">
                    <Box style={{ cursor: "pointer" }} >
                        <Typography variant="h5" id="colorText">
                            Sustentabilizei
                        </Typography>
                    </Box>
                    

                    
                    <Box display="flex" justifyContent="start" className= "container2" >
                        <Box mx={2} style={{ cursor: "pointer" }}>
                            <Typography variant="h6" color="inherit" id="efeito">
                               Home
                            </Typography>
                        </Box>
                        <Box mx={2} style={{ cursor: "pointer" }}  className= "container2">
                            <Typography variant="h6" color="inherit" id="efeito">Sobre Nós</Typography>
                        </Box>
                        <Box mx={2} style={{ cursor: "pointer" }}  className= "container2" id="efeito">
                            <Typography variant="h6" color="inherit">
                                Contato
                            </Typography>
                        </Box>
                    </Box>
                   <Box 
                   display = "inline-flex"
                   justifyContent = "end"
                   alignItems = "center"
                   marginLeft = "1230px"
                   >
                    <Box display="flex"  >
                        <Box mx={1} style={{ cursor: "pointer" }}>
                            <Typography variant="h6" color="inherit">
                               Login
                            </Typography>
                        </Box>
                    </Box>
                    <Box display="flex"  >
                        <Box mx={1} style={{ cursor: "pointer" }}>
                            <Typography variant="h6" color="inherit">
                               Cadastre-se
                            </Typography>
                        </Box>
                    </Box>
                    </Box>
                </Toolbar>
            </AppBar>

        </>
    )
}

export default Navbar;